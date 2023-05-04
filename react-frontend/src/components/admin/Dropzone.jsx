import React, { useCallback, useEffect, useMemo, useState } from 'react';
import { useDropzone } from 'react-dropzone';
import { useStateContext } from '../../contexts/StateContext';
import ThumbnailServices from '../../services/ThumbnailServices';


const baseStyle = {
    flex: 1,
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    padding: '20px',
    borderWidth: 2,
    borderRadius: 2,
    borderColor: '#eeeeee',
    borderStyle: 'dashed',
    backgroundColor: '#fafafa',
    color: '#bdbdbd',
    outline: 'none',
    transition: 'border .24s ease-in-out'
};

const focusedStyle = {
    borderColor: '#2196f3'
};

const acceptStyle = {
    borderColor: '#00e676'
};

const rejectStyle = {
    borderColor: '#ff1744'
};
const thumbsContainer = {
    display: 'flex',
    flexDirection: 'row',
    flexWrap: 'wrap',
    marginTop: 16
};

const thumb = {
    display: 'inline-flex',
    borderRadius: 2,
    border: '1px solid #eaeaea',
    marginBottom: 8,
    marginRight: 8,
    width: 100,
    height: 100,
    padding: 4,
    boxSizing: 'border-box'
};

const thumbInner = {
    display: 'flex',
    minWidth: 0,
    overflow: 'hidden'
};

const img = {
    display: 'block',
    width: 'auto',
    height: '100%'
};



export function StyledDropzone() {
    const [files, setFiles] = useState([]);
    const { isUpload, setIsUpload, setImages } = useStateContext();
    const thumbs = files.map(file => (
        <div style={thumb} key={file.name}>
            <div style={thumbInner}>
                <img
                    src={file.preview}
                    style={img}
                    // Revoke data uri after image is loaded
                    onLoad={() => { URL.revokeObjectURL(file.preview) }}
                />
            </div>
        </div>
    ));

    useEffect(() => {
        // Make sure to revoke the data uris to avoid memory leaks, will run on unmount
        return () => files.forEach(file => URL.revokeObjectURL(file.preview));
    }, []);


    // const onDrop = useCallback(async (acceptedFiles) => {

    //     Object.keys(acceptedFiles).forEach(i => {
    //         const file = acceptedFiles[i];
    //         const reader = new FileReader();
    //         reader.onload = (e) => {
    //             //server call for uploading or reading the files one-by-one
    //             //by using 'reader.result' or 'file'
    //             setImage(arr => [...arr, reader.result])
    //         }
    //         reader.readAsDataURL(file);
    //     })
    // }, [setImage])

    const {
        getRootProps,
        getInputProps,
        isFocused,
        isDragAccept,
        isDragReject,
        acceptedFiles,

    } = useDropzone({
        onDrop: acceptedFiles => {
            setFiles(acceptedFiles.map(file => Object.assign(file, {
                preview: URL.createObjectURL(file)
            })));

            setImages(acceptedFiles);
        },
        accept: {
            'image/*': [],
        },
        maxFiles: 4
    });

    const style = useMemo(() => ({
        ...baseStyle,
        ...(isFocused ? focusedStyle : {}),
        ...(isDragAccept ? acceptStyle : {}),
        ...(isDragReject ? rejectStyle : {})
    }), [
        isFocused,
        isDragAccept,
        isDragReject
    ]);

    // const files = acceptedFiles.map(file => (
    //     <div key={file.path} >
    //         <img className='w-20 h-20' src={image} alt="" />
    //     </div>
    // ));

    return (
        <div className="container">
            <div {...getRootProps({ style })}>
                <input {...getInputProps()} />
                <p>Drag 'n' drop some files here, or click to select files</p>
                <aside>
                    <h4>Files</h4>
                </aside>
                <aside style={thumbsContainer}>
                    {thumbs}
                </aside>
            </div>
        </div>
    );
}
